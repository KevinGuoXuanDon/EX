package leetcode.Stimulate;
import java.util.*;

/**
 * @author xuandongguo
 * @date
 */
class NumberOfOrdersInTheBacklog {
    private static final int mod = 1000000007;
    public int getNumberOfBacklogOrders(int[][] orders){
        PriorityQueue<Order> buy = new PriorityQueue<>((a,b)->b.price - a.price);
        PriorityQueue<Order> sell = new PriorityQueue<>((a,b)->a.price - b.price);
        for (int[] i : orders){
            Order order = new Order(i[0],i[1],i[2]);
            if(order.type == 0) {
                calculate(buy, sell, order,true);
            } else {
                calculate(sell, buy, order,false);
            }
        }
        int res = 0;
        for (Order order : buy) {
            //System.out.println("buyOrder "+order.toString());
            res = (res + order.num) % mod;
        }
        for (Order order : sell) {
            //System.out.println("sellOrder "+order.toString());
            res = (res + order.num) % mod;
        }
        return res;
    }

    public void calculate(PriorityQueue<Order> buy, PriorityQueue<Order> sell, Order order, boolean flag){
        while (order.num>0 && !sell.isEmpty() && (flag? order.price >= sell.peek().price :order.price <= sell.peek().price)) {
            Order sellOrder = sell.poll();
            int saleAmount = Math.min(sellOrder.num, order.num);
            order.num -= saleAmount;
            sellOrder.num -= saleAmount;
            if(sellOrder.num > 0){
                sell.add(sellOrder);
            }
        }
        if (order.num > 0) {
            buy.add(order);
        }
    }

    class Order{
        int price;
        int num;
        int type;
        public Order(){

        }
        public Order(int price, int num, int type){
            this.price = price;
            this.num = num;
            this.type = type;
        }
        @Override
        public String toString() {
            return "Order{" +
                    "price=" + price +
                    ", num=" + num +
                    ", type=" + type +
                    '}';
        }
    }
}