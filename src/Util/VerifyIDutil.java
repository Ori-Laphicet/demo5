package Util;


public class VerifyIDutil {
    public boolean isreal(String cardcode) {
        if (cardcode.length() != 18){
            return  false;
        }else{
            int i = 0;
            String r = "error";
            String lastnumber = "";

            i += Integer.parseInt(cardcode.substring(0, 1)) * 7;
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
            i += Integer.parseInt(cardcode.substring(16,17)) * 2;
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
            if (r.equals(lastnumber.toLowerCase())) {
                return true;
            }
            return false;

        }

    }























    /*public boolean isreal(String id){
        boolean result = false;
        char[] identity = id.toCharArray();
        int re = -1;
        if (identity.length != 18){
            return result;
        }else {
            int mod = 0;
            mod += identity[0] * 7;
            mod += identity[1] * 9;
            mod += identity[2] * 10;
            mod += identity[3] * 5;
            mod += identity[4] * 8;
            mod += identity[5] * 4;
            mod += identity[6] * 2;
            mod += identity[7] * 1;
            mod += identity[8] * 6;
            mod += identity[9] * 3;
            mod += identity[10] * 7;
            mod += identity[11] * 9;
            mod += identity[12] * 10;
            mod += identity[13] * 5;
            mod += identity[14] * 8;
            mod += identity[15] * 4;
            mod += identity[16] * 2;
            mod = mod % 11;
            switch (mod){
                case 0:re = 1;break;
                case 1:re = 0;break;
                case 2:re = 11;break;
                case 3:re = 9;break;
                case 4:re = 8;break;
                case 5:re = 7;break;
                case 6:re = 6;break;
                case 7:re = 5;break;
                case 8:re = 4;break;
                case 9:re = 3;break;
                case 10:re = 2;break;
            }
            if (re == 11 && identity[17] == 'X'){
                result = true;
            }else if (re == (int) (identity[17])){
                result = true;
            }
        }

        return result;
    }*/
}
