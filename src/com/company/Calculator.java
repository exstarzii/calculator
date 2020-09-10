package com.company;

public class Calculator {

    public static String evaluate(String input) throws NumberFormatException {
        boolean isRim = input.matches("[IVX].+");
        String[] ss = input.split("[-/\\+\\*]");
        int[] nums = new int[ss.length];
        if(ss.length!=2){
            throw new NumberFormatException();
        }

        if(isRim){
            for (int i = 0; i < ss.length; i++) {
                switch (ss[i].trim()){
                    case "I":
                        nums[i] = 1;
                        break;
                    case "II":
                        nums[i] = 2;
                        break;
                    case "III":
                        nums[i] = 3;
                        break;
                    case "IV":
                        nums[i] = 4;
                        break;
                    case "V":
                        nums[i] = 5;
                        break;
                    case "VI":
                        nums[i] = 6;
                        break;
                    case "VII":
                        nums[i] = 7;
                        break;
                    case "VIII":
                        nums[i] = 8;
                        break;
                    case "IX":
                        nums[i] = 9;
                        break;
                    case "X":
                        nums[i] = 10;
                        break;
                    default:
                        throw new NumberFormatException();
                }
            }
        }else{
            for (int i = 0; i < ss.length; i++) {
                nums[i] = Integer.parseInt(ss[i]);
                if(nums[i]<1||nums[i]>10){
                    throw new NumberFormatException();
                }
            }
        }

        String operation = input.replaceAll("[^-/\\+\\*]","");
        int result=0;
        switch (operation){
            case "+":
                result= nums[0]+nums[1];
                break;
            case "-":
                result= nums[0]-nums[1];
                break;
            case "/":
                result= nums[0]/nums[1];
                break;
            case "*":
                result= nums[0]*nums[1];
                break;
            default:
                throw new NumberFormatException();
        }
        if(!isRim) {
            return Integer.toString(result);
        }else{
            if(result==0) {
                throw new NumberFormatException();
            }
            StringBuilder builder = new StringBuilder();
            while (result!=0){
                if(result>=9) {
                    builder.append("X");
                    result -=10;
                }
                else if(result>=4){
                    builder.append("V");
                    result-=5;
                }else{
                    builder.append("I");
                    result-=1;
                }
                if(result<0){
                    builder.insert(builder.length()-1,"I");
                    result+=1;
                }

            }
            return builder.toString();
        }
    }
}
