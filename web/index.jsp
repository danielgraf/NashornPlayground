<%-- 
    Document   : nashornRunner
    Created on : Oct 25, 2016, 10:31:37 AM
    Author     : dgraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="nashorn">
    <head>
        <title>Nashorn Playground</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://unpkg.com/jquery@3.1.0/dist/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="/NashornPlayground/css/nashorn.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-12">
                        <h1>Nashorn playground <small> Dan Graf for LeedsJS, 26.10.2016</small></h1>
                    </div>
                    <div class="col-md-12">
                        <ul class="nav nav-tabs">
                            <li role="presentation"><a href="#slides" class="active" aria-controls="slides" role="tab" data-toggle="tab">Introduction</a></li>
                            <li role="presentation"><a href="#helloworld" aria-controls="helloworld" role="tab" data-toggle="tab">Hello, world!</a></li>
                            <li role="presentation"><a href="#addingjava" aria-controls="addingjava" role="tab" data-toggle="tab">Adding Java</a></li>
                            <li role="presentation"><a href="#bindings" aria-controls="bindings" role="tab" data-toggle="tab">Bindings</a></li>
                            <li role="presentation"><a href="#performance" aria-controls="performance" role="tab" data-toggle="tab">Performance</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="slides"><jsp:include page="slides.jsp"></jsp:include></div>
                        <div role="tabpanel" class="tab-pane" id="helloworld"><jsp:include page="nashornRunner.jsp"><jsp:param name="servlet" value="HelloWorld"/></jsp:include></div>
                        <div role="tabpanel" class="tab-pane" id="addingjava"><jsp:include page="nashornRunner.jsp"><jsp:param name="servlet" value="AddingJava"/></jsp:include></div>
                        <div role="tabpanel" class="tab-pane" id="bindings"><jsp:include page="nashornRunner.jsp"><jsp:param name="servlet" value="Bindings"/></jsp:include></div>
                        <div role="tabpanel" class="tab-pane" id="performance"><jsp:include page="nashornRunner.jsp"><jsp:param name="servlet" value="Performance"/></jsp:include></div>
                    </div>
                </div>
            </div>
        </div>
        <script src="/NashornPlayground/ace/src-min/ace.js"></script>
        <script src="https://unpkg.com/angular@1.5.8/angular.min.js"></script>
        <script src="/NashornPlayground/ace/ui-ace.js"></script>
        <script src="https://unpkg.com/requirejs@2.3.2/require.js"></script>
        <script src="/NashornPlayground/ace/src-min/ext-language_tools.js"></script>
        <script src="/NashornPlayground/js/nashorn.js"></script>
        <script src="/NashornPlayground/js/nashorncontroller.js"></script>
    </body>
</html>
