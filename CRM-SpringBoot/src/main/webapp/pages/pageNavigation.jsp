<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<nav>
    <ul class="pagination">
        <li <c:if test="${customerQuery.page == 1}">class="disabled" </c:if> >
            <%-- 若页码以及为1则禁用上一页            --%>
            <a onclick="prePage()" href="javascript:void(0);">上一页</a>
        </li>

        <li>
            <a href="javascript:void(0);">${customerQuery.page}/${pages}</a>
        </li>


        <li <c:if test="${customerQuery.page >= pages }">class="disabled" </c:if> >
            <%-- 若页码以及为1则禁用下一页            --%>
            <a onclick="nextPage()" href="javascript:void(0);">下一页</a>
        </li>

    </ul>
</nav>
<script>
    //上一页下一页  就是获取条件查询表单中的page输入框,将它值进行加1或减1
    function prePage() {
        //当前页大于1 则可以执行上一页
        if (${customerQuery.page > 1}) {
            //page-1
            $("#page").val(parseInt($("#page").val()) - 1);
            //提交表单
            $("#form").submit();
        }
    }

    function nextPage() {
        //当前页小于总页数 则可以执行下一页
        if (${customerQuery.page < pages}) {
            //page-1
            $("#page").val(parseInt($("#page").val()) + 1);
            //提交表单
            $("#form").submit();
        }

    }
    
</script>
</body>
</html>
