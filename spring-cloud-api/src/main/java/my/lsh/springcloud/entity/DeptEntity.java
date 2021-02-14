package my.lsh.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.jws.HandlerChain;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class DeptEntity implements Serializable {
    private Long id;
    private String name;
    private String dataSource;

}
