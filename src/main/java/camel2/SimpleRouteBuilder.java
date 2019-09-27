package camel2;

import org.apache.camel.builder.RouteBuilder;

public class SimpleRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:D:/3.- tmp/inputFolder?noop=true").to("file:D:/3.- tmp/outputFolder");
    }

}