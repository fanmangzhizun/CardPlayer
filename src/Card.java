import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by faithpercious on 2017/9/25.
 * 创建扑克牌以及洗牌操作
 *
 */
public class Card {

    private String card[] = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private String colors[] = {"♠", "♥", "♣", "♦"};
    private List<String> cardList = new ArrayList<>();
    private List<String> wcardList = new ArrayList<>();
    private List<String> cardList2 = new ArrayList<>();

    public String[] getCard() {
        return card;
    }

    public String[] getColors() {
        return colors;
    }


    public Card() {//初始化扑克牌
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                cardList.add(colors[j] + card[i]);
            }
        }

        cardList2.addAll(cardList);
        //开始洗牌
        for (int j = 0; j < cardList.size(); j++) {
            int num;
            do {
                num = new Random().nextInt(cardList.size());
                wcardList.add(cardList.get(num).toString());
                cardList.remove(num);
            }
            while (cardList.size() != 0);
        }

    }

    public List<String> getWcardList() {
        return wcardList;
    }

    public void testinit() {
        for (String a : cardList2
                ) {
            System.out.print(a + ",");
        }

    }
}
