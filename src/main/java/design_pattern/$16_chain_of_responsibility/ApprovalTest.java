package design_pattern.$16_chain_of_responsibility;

/**
 * @Author young
 * @Date 2020/5/28 17:24
 * @Desc
 **/
public class ApprovalTest {
    public static void main(String[] args) {
        Leader leader1 = new ClassAdvisor();
        Leader leader2 = new DepartmentHead();
        Leader leader3 = new Dean();
        leader1.setNext(leader2);
        leader2.setNext(leader3);
        leader1.Approval(1);
        leader1.Approval(6);
        leader1.Approval(9);
    }
}

abstract class Leader {
    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader leader) {
        this.next = leader;
    }

    public abstract void Approval(int day);
}

class ClassAdvisor extends Leader {


    @Override
    public void Approval(int day) {
        if (day <= 2) {
            System.out.println("班主任批准您请假" + day + "天。");
        } else if (null != getNext()) {
            getNext().Approval(day);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}

class DepartmentHead extends Leader {

    @Override
    public void Approval(int day) {
        if (day <= 7) {
            System.out.println("系主任批准您请假" + day + "天。");
        } else if (null != getNext()) {
            getNext().Approval(day);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}

class Dean extends Leader {

    @Override
    public void Approval(int day) {
        if (day <= 10) {
            System.out.println("院长批准您请假" + day + "天。");
        } else if (null != getNext()) {
            getNext().Approval(day);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}
