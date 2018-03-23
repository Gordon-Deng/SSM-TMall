package com.gordon.tmall.util;

public class Page {

    //开始页数
    //每页显示个数
    //总个数
    //参数
    
    private int start;
    private int count;
    private int total;
    private String param;
    
    private static final int defaultCount = 5;

    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }
    
    public Page() {
        count = defaultCount;
    }
    
    public void setStart(int start) {
        this.start = start;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getStart() {
    
        return start;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public String getParam() {
        return param;
    }

    public static int getDefaultCount() {
        return defaultCount;
    }

    public boolean isHasPreviouse(){
        if(start == 0) {
            return false;
        }
            return true;
    }
    public boolean isHasNext(){
        if(start == getLast()) {
            return false;
        }
        return true;
    }

    public int getTotalPage(){
        int totalPage;
        // 假设总数是50，是能够被5整除的，那么就有10页
        if (0 == total % count){
            totalPage = total /count;
        }
            // 假设总数是51，不能够被5整除的，那么就有11页
        else {
            totalPage = total / count + 1;
        }

        if(0==totalPage) {
            totalPage = 1;
        }
        return totalPage;

    }

    public int getLast(){
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % count) {
            last = total - count;
        }
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else {
            last = total - total % count;
        }
        last = last<0?0:last;
        return last;
    }
    
    @Override
    public String toString() {
        return "Page [start=" + start + ", count=" + count + ", total=" + total + ", getStart()=" + getStart()
                + ", getCount()=" + getCount() + ", isHasPreviouse()=" + isHasPreviouse() + ", isHasNext()="
                + isHasNext() + ", getTotalPage()=" + getTotalPage() + ", getLast()=" + getLast() + "]";
    }
}
