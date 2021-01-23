# webfluxDemo
webflux学习总结

## 功能端点(functional endpoints)
在WebFlux.fn中，HTTP请求使用HandlerFunction：处理，该函数接受 ServerRequest并返回延迟ServerResponse（即Mono<ServerResponse>）。请求和响应对象都具有不可变的协定，这些协定为JDK 8提供了对HTTP请求和响应的友好访问。 与基于注释的编程模型中方法HandlerFunction的主体等效@RequestMapping。

传入的请求使用：路由到处理函数，RouterFunction该函数接受ServerRequest并返回一个延迟的HandlerFunction（即Mono<HandlerFunction>）。当路由器功能匹配时，返回处理程序功能。否则为空Mono。 RouterFunction与@RequestMapping注解等效，但主要区别在于路由器功能不仅提供数据，还提供行为。

RouterFunctions.route() 提供了一个有助于构建路由器的路由器构建器

示例代码在functional.endpoints包下

