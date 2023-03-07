package ioc.overview.dependency.domain;

import ioc.overview.dependency.annotation.Super;
import lombok.Data;
import lombok.ToString;

@Super
@Data
@ToString(callSuper = true)
public class SuperUser extends User {
    private String address;
}
