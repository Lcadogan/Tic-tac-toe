import java.util.Random;

public abstract class AI extends Player{

    public AI(String name, char fishkaPl) {
        super(name, fishkaPl);
    }

    public void print() {
        System.out.println("Making move level \""+ super.getName() +"\"");
    }

    public String [] moveRandom() {
        Random random = new Random();
        boolean flag = true;
        String [] tmp = new String[2];
        while(flag) {
            tmp[0]= String.valueOf(random.nextInt(3) + 1);
            tmp[1]= String.valueOf(random.nextInt(3) + 1);
            flag = !Field.checkEmptyCell(tmp);
        }
        return tmp;
    }
}
