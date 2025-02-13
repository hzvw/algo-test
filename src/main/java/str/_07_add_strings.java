package str;

public class _07_add_strings {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;

        int carry = 0;
        while(i>=0 || j>=0){
            int n1 = 0;
            if(i>=0){
                n1 = num1.charAt(i) - '0';
            }

            int n2 = 0;
            if(j >= 0){
                n2 = num2.charAt(j) - '0';
            }

            int temp = (n1 + n2 + carry) % 10;
            res.append(temp+"");
            if(n1 + n2 + carry >= 10){
                carry = 1;
            }else{
                carry = 0;
            }

            i--;
            j--;
        }
        if(carry == 1){
            res.append(carry+"");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new _07_add_strings().addStrings("486", "1241");
        System.out.println(res);
    }


}
