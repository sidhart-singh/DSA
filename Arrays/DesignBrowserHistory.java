package Arrays;

class ListNode {
    String value = "";
    ListNode previous = null;
    ListNode next = null;

    ListNode(String current, ListNode previous, ListNode next){
        this.value = current;
        this.previous = previous;
        this.next = next;
    }
}

class BrowserHistory {
    ListNode currentPage;

    public BrowserHistory(String homepage) {
        this.currentPage = new ListNode(homepage, null, null);
    }
    
    public void visit(String url) {
        this.currentPage.next = new ListNode(url, currentPage, null);
        this.currentPage = currentPage.next;
    }
    
    public String back(int steps) {
        while(this.currentPage.previous != null && steps > 0){
            currentPage = currentPage.previous;
            steps--;
        }
        return currentPage.value;
    }
    
    public String forward(int steps) {
        while(this.currentPage.next != null && steps > 0){
            currentPage = currentPage.next;
            steps--;
        }
        return currentPage.value;
    }
}

