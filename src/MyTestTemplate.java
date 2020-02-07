import org.junit.jupiter.api.extension.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class MyTestTemplate implements TestTemplateInvocationContextProvider {
    @Override
    public boolean supportsTestTemplate(ExtensionContext extensionContext) {
        return true;
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext extensionContext) {
        return Stream.of(invocationContext("xxxx"),invocationContext("banana"));
    }
    //实现方法@Test
    private TestTemplateInvocationContext invocationContext(String parameters) {
        return new TestTemplateInvocationContext(){
            @Override
            public String getDisplayName(int invocationIndex) {
                return parameters;
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return Collections.singletonList(new ParameterResolver() {
                    //支持的参数必须是字符串
                    @Override
                    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                        return parameterContext.getParameter().getType().equals(String.class);
                    }

                    //处理参数直接返回
                    @Override
                    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                        return parameters;
                    }
                });
            }
        };
    }
}
