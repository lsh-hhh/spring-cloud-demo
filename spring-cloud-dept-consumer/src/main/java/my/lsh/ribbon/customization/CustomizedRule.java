package my.lsh.ribbon.customization;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomizedRule extends AbstractLoadBalancerRule {

    private AtomicInteger nextServerCyclicCounter;
    private AtomicInteger currentIndex;
    private Integer total;

    private static Logger log = LoggerFactory.getLogger(CustomizedRule.class);

    public CustomizedRule() {
        nextServerCyclicCounter = new AtomicInteger(0);
        currentIndex = new AtomicInteger(0);
        total = 0;
    }

    public CustomizedRule(ILoadBalancer lb) {
        this();
        setLoadBalancer(lb);
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            log.warn("no load balancer");
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                log.warn("No up servers available from load balancer: " + lb);
                return null;
            }

//            int nextServerIndex = incrementAndGetModulo(.);
//            server = allServers.get(nextServerIndex);
            if (total < 5){
                total ++;
                server = allServers.get(currentIndex.intValue());
            }else {
                currentIndex.incrementAndGet();
                total = 0;
                if (currentIndex.intValue() >= serverCount){
                    currentIndex = new AtomicInteger(0);
                }
                server = allServers.get(currentIndex.intValue());
            }

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {
            log.warn("No available alive servers after 10 tries from load balancer: "
                    + lb);
        }
        return server;
    }

    private int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = nextServerCyclicCounter.get();
            int next = (current + 1) % modulo;
            if (nextServerCyclicCounter.compareAndSet(current, next))
                return next;
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}
