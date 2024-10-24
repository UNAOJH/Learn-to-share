import java.util.*;

public class PokerGame {

    static HashMap<Integer, String> hashMap = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        //准备牌
        String[] color = {"♠", "♥", "♦", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        //定义序号
        int serialNumber = 1;
        //准备牌盒
        for (String n : number) {
            //依次表示每个花色
            for (String c : color) {
                //依次表示数字
                hashMap.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        hashMap.put(serialNumber, "大王");
        list.add(serialNumber);
        serialNumber++;

        hashMap.put(serialNumber, "小王");
        list.add(serialNumber);
        System.out.println(hashMap);
        System.out.println(list);
    }

    public PokerGame() {

        //洗牌
        Collections.shuffle(list);
        //发牌
        TreeSet<Integer> landlord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);
            if (i <= 2) {
                landlord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }
        lookPoker("底牌", landlord);
        lookPoker("玩家1", player1);
        lookPoker("玩家2", player2);
        lookPoker("玩家3", player3);
    }

    //看牌（把牌的序号转换成牌）
    public void lookPoker(String name, TreeSet<Integer> treeSet) {
        System.out.print(name + ":  ");
        for (int serialNumber : treeSet) {

            System.out.print(hashMap.get(serialNumber));
        }
        System.out.println(" ");

    }
}