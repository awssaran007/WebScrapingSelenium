package testmetadata;

public class TestCase {
    private String operand1;
    private String operand2;
    private String result;


    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String value) {
        this.operand1 = value;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String value) {
        this.operand2 = value;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String value) {
        this.result = value;
    }

    public String toString(){
        return "\noperand1 :" + operand1 ;
    }
}

