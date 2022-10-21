package BluePrint;

public class LinkSheet {
    private String link;
    private String status;

    public LinkSheet() {
    }

    public LinkSheet(String link, String status) {
        this.link = link;
        this.status = status;
    }

    public void print() {
        System.out.println(link + "-------" + status);
    }

    public String getLink() {
        return link;
    }

    public String getStatus() {
        return status;
    }
}
