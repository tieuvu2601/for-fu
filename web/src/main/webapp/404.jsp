<%@ include file="/common/taglibs.jsp"%>
<page:applyDecorator name="default">
<head>
    <title><fmt:message key="404.title"/></title>
    <meta name="heading" content="<fmt:message key='404.title'/>"/>
    <link rel="stylesheet" href="<c:url value='/themes/${appConfig["csstheme"]}/css/404.css' />" />
</head>
<body>
    <div class="content-wrapper">
        <section class="content">
            <div class="callout callout-danger">
                <h3 style="margin-top: 0px;"><fmt:message key='404.title'/></h3>
                <fmt:message key="404.message">
                    <fmt:param><c:url value="/"/></fmt:param>
                </fmt:message>
                <p class="link"><a href="<c:url value="/home.html"/>" class="btn"><fmt:message key="button.backToHome"/></a></p>
            </div>
        </section>
    </div>
</body>
</page:applyDecorator>