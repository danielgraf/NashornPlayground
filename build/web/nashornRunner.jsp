<%-- 
    Document   : nashornRunner
    Created on : Oct 25, 2016, 10:31:37 AM
    Author     : dgraf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container" ng-controller="NashornController">
    <div class="col-md-12" ng-init="init('${param.servlet}');">
        <p class="h2">{{nashornobject.name}}</p>
        <p class="h5">Editor</p>
        <div class="form-group">
            <div id="editor-{{nashornobject.name}}" ui-ace="{mode: 'javascript', theme:'eclipse', enableBasicAutocompletion: 'true', enableSnippets: 'true', enableLiveAutocompletion: 'true'}" rows="20" class="scripteditor stretch well" ng-model="nashornobject.script"></div>
        </div>
        <button type="button" class="btn btn-success" ng-click="runScript()">Run</button>
        <button type="button" class="btn btn-default" ng-click="resetScript()">Reset</button>
        <p class="h4">Execution history</p>
        <div ng-repeat="execution in results track by execution.executionid">
            <div ng-class="{'alert alert-success alert-dismissable': execution.result, 'alert alert-danger alert-dismissable': !execution.result}">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <p><a role="button" data-toggle="collapse" href="#output-{{execution.executionid}}" aria-expanded="false" aria-controls="collapseExample"><span class="glyphicon glyphicon-list-alt"></span></a>&nbsp;Execution at {{execution.executiontimestamp}} / duration {{execution.executiontime}}ms</p>                
                <span ng-if="execution.lasterror !== ''"><span class="glyphicon glyphicon-exclamation-sign"></span> <u id="error-{{execution.executionid}}">{{execution.lasterror}}</u></span>
                <div class="collapse" id="output-{{execution.executionid}}">
                    <div class="well">
                        <div id="editor-{{execution.executionid}}" ng-if="execution.output !== ''" ng-readonly='true' ui-ace="{mode: 'text', theme:'eclipse'}" rows="20" class="scripteditor stretch" ng-model="execution.output"></div>
                    </div>
                </div>
            </div>    
        </div>
    </div>
</div>

