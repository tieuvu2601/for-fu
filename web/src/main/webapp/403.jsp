<%@ include file="/common/taglibs.jsp"%>

<page:applyDecorator name="default">

<head>
    <title><fmt:message key="403.title"/></title>
    <meta name="heading" content="<fmt:message key='403.title'/>"/>
</head>

<body>
<div class="content-wrapper">
    <section class="content">
        <div class="callout callout-danger">
            <h3 style="margin-top: 0px;"><fmt:message key='403.title'/></h3>
            <fmt:message key="403.message">
                <fmt:param><c:url value="/"/></fmt:param>
            </fmt:message></div>
    </section>
</div>
</body>
</page:applyDecorator>