<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="/common/taglibs.jsp"%>

<security:authorize ifNotGranted="ADMIN">
    <c:redirect url="/welcome.html?firstLogin=true"/>
</security:authorize>
<c:redirect url="/home.html"/>

