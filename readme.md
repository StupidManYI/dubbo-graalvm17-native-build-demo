(node before run application ,you need to modify the application.yml)

```
<dependency>
            <groupId>org.apache.dubbo</groupId>
            <artifactId>dubbo</artifactId>
            <version>${dubbo.verison}</version>
            <exclusions>
                <exclusion>
                    <artifactId>hessian-lite</artifactId>
                    <groupId>com.alibaba</groupId>
                </exclusion>
            </exclusions>
        </dependency>
```
