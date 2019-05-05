
// 专家相关函数
function backToExpManaege() {
    window.location.href = "Expert?param=gotomanage";
}

function addExp() {
    $("#div4").load("addExp.jsp");
}

function updateExp() {
    var identity = $("input[type='radio']:checked").val();
    $("#div4").load("UpdateExp.jsp?ID="+identity);
}

function delExp() {
    var identity = $("input[type='radio']:checked").val();
    window.location.href = "Expert?param=del&ID="+identity;

}

function distribute() {
    var attList = $("input[name='select']");
    for (var i=0;i<attList.length;i++){
        if (attList[i].checked) {
            var identity = attList[i].value;
           // console.log("来自于各种js,distribute"+identity);
        }
    }
    $("#div4").load("Project?param=findUndis&id="+identity);
}

function showExpPro() {
    var identity = $("input[type='radio']:checked").val();
    $("#div4").load("Project?param=show&ID="+identity);
}




// 项目相关函数
function showPro() {
    window.location.href ="ProManager.jsp";

}
function addPro() {
    $("#div4").load("addProject.jsp");
}
function updatePro() {
    var name = $("input[type='radio']:checked").val();
    $("#div4").load("UpdatePro.jsp?name="+name);
}
function delPro() {
    var name = $("input[type='radio']:checked").val();
    window.location.href = "Project?param=del&name="+name;
}
function distributePro(id) {
    var name = $("input[type='radio']:checked").val();
    var identity = id;
    //console.log("来自distributePro"+identity);
    window.location.href = "Expert?param=addpro&ID="+identity+"&name="+name;
}
function backToProManager() {
    window.location.href = "Project?param=gotomanage";

}
function UnAssign(id) {
    console.log("来自UnAssign"+id);
    var name = $("input[type='radio']:checked").val();
    window.location.href = "Expert?param=unassign&name="+name+"&identity="+id;
}




//分页功能
var pageSize = 5;    //每页显示的记录条数
var curPage=0;        //当前页
var lastPage;        //最后页
var direct=0;        //方向
var len;            //总行数
var page;            //总页数
var begin;
var end;


$(document).ready(function display(){
    len =$("#table1 tr").length - 1;    // 求这个表的总行数，剔除第一行介绍
    page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
    // alert("page==="+page);
    curPage=1;    // 设置当前为第一页
    displayPage(1);//显示第一页

    document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";    // 显示当前多少页
    document.getElementById("sjzl").innerHTML="数据总量 " + len + "";        // 显示数据量
    document.getElementById("pageSize").value = pageSize;



    $("#btn1").click(function firstPage(){    // 首页
        curPage=1;
        direct = 0;
        displayPage();
    });
    $("#btn2").click(function frontPage(){    // 上一页
        direct=-1;
        displayPage();
    });
    $("#btn3").click(function nextPage(){    // 下一页
        direct=1;
        displayPage();
    });
    $("#btn4").click(function lastPage(){    // 尾页
        curPage=page;
        direct = 0;
        displayPage();
    });
    $("#btn5").click(function changePage(){    // 转页
        curPage=document.getElementById("changePage").value * 1;
        if (!/^[1-9]\d*$/.test(curPage)) {
            alert("请输入正整数");
            return ;
        }
        if (curPage > page) {
            alert("超出数据页面");
            return ;
        }
        direct = 0;
        displayPage();
    });


    $("#pageSizeSet").click(function setPageSize(){    // 设置每页显示多少条记录
        pageSize = document.getElementById("pageSize").value;    //每页显示的记录条数
        if (!/^[1-9]\d*$/.test(pageSize)) {
            alert("请输入正整数");
            return ;
        }
        len =$("#table1 tr").length - 1;
        page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
        curPage=1;        //当前页
        direct=0;        //方向
        firstPage();
    });
});

function displayPage(){
    if(curPage <=1 && direct==-1){
        direct=0;
        alert("已经是第一页了");
        return;
    } else if (curPage >= page && direct==1) {
        direct=0;
        alert("已经是最后一页了");
        return ;
    }

    lastPage = curPage;

    // 修复当len=1时，curPage计算得0的bug
    if (len > pageSize) {
        curPage = ((curPage + direct + len) % len);
    } else {
        curPage = 1;
    }


    document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";        // 显示当前多少页

    begin=(curPage-1)*pageSize + 1;// 起始记录号
    end = begin + 1*pageSize - 1;    // 末尾记录号


    if(end > len ) end=len;
    $("#table1 tr").hide();    // 首先，设置这行为隐藏
    $("#table1 tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
        if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
            $(this).show();
    });
}


