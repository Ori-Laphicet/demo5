function idisreal(cardcode) {
    if (cardcode.length != 18){
        alert("请输入正确的身份证号");
        $("input[name='identity']").val("");
    }else{
        var i = 0;
        var r = "error";
        var lastnumber = "";
        i +=(cardcode.substring(0, 1)) * 7;
        i += (cardcode.substring(1, 2)) * 9;
        i += (cardcode.substring(2, 3)) * 10;
        i += (cardcode.substring(3, 4)) * 5;
        i += (cardcode.substring(4, 5)) * 8;
        i += (cardcode.substring(5, 6)) * 4;
        i += (cardcode.substring(6, 7)) * 2;
        i += (cardcode.substring(7, 8)) * 1;
        i += (cardcode.substring(8, 9)) * 6;
        i += (cardcode.substring(9, 10)) * 3;
        i += (cardcode.substring(10,11)) * 7;
        i += (cardcode.substring(11,12)) * 9;
        i += (cardcode.substring(12,13)) * 10;
        i += (cardcode.substring(13,14)) * 5;
        i += (cardcode.substring(14,15)) * 8;
        i += (cardcode.substring(15,16)) * 4;
        i += (cardcode.substring(16,17)) * 2;

       /* i += Integer.parseInt(cardcode.substring(0, 1)) * 7;
        i += Integer.parseInt(cardcode.substring(1, 2)) * 9;
        i += Integer.parseInt(cardcode.substring(2, 3)) * 10;
        i += Integer.parseInt(cardcode.substring(3, 4)) * 5;
        i += Integer.parseInt(cardcode.substring(4, 5)) * 8;
        i += Integer.parseInt(cardcode.substring(5, 6)) * 4;
        i += Integer.parseInt(cardcode.substring(6, 7)) * 2;
        i += Integer.parseInt(cardcode.substring(7, 8)) * 1;
        i += Integer.parseInt(cardcode.substring(8, 9)) * 6;
        i += Integer.parseInt(cardcode.substring(9, 10)) * 3;
        i += Integer.parseInt(cardcode.substring(10,11)) * 7;
        i += Integer.parseInt(cardcode.substring(11,12)) * 9;
        i += Integer.parseInt(cardcode.substring(12,13)) * 10;
        i += Integer.parseInt(cardcode.substring(13,14)) * 5;
        i += Integer.parseInt(cardcode.substring(14,15)) * 8;
        i += Integer.parseInt(cardcode.substring(15,16)) * 4;
        i += Integer.parseInt(cardcode.substring(16,17)) * 2;*/
        i = i % 11;
        lastnumber =cardcode.substring(17,18);
        if (i == 0) {
            r = "1";
        }
        if (i == 1) {
            r = "0";
        }
        if (i == 2) {
            r = "x";
        }
        if (i == 3) {
            r = "9";
        }
        if (i == 4) {
            r = "8";
        }
        if (i == 5) {
            r = "7";
        }
        if (i == 6) {
            r = "6";
        }
        if (i == 7) {
            r = "5";
        }
        if (i == 8) {
            r = "4";
        }
        if (i == 9) {
            r = "3";
        }
        if (i == 10) {
            r = "2";
        }
        if (r == (lastnumber.toLowerCase())) {
            return true;
        }
        alert("请输入正确的身份证号");

    }

}