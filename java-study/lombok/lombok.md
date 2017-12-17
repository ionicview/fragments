1
 download lombok.jar
 
2
 in eclipse.ini 
 append this statment: -javaagent:lombok.jar(path of use in workspace)
 
3
 restartup eclipse
```java

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LombakDemo {

	private String testField;

	public static void main(String[] args) {
		LombakDemo lombakDemo = LombakDemo.builder().testField("1").build();
		System.out.println(lombakDemo.getTestField());
	}
}

```
