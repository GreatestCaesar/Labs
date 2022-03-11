package by.bsac.practical8.individual;

public class Site {
    private String title;
    private String type;
    private String email;
    private String news;
    private String free;
    private String authorize;

    public Site(String title, String type, String email, String news, String free, String authorize) {
        this.title = title;
        this.type = type;
        this.email = email;
        this.news = news;
        this.free = free;
        this.authorize = authorize;
    }

    public Site(){ }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getFree() {
        return free;
    }

    public void setFree(String free) {
        this.free = free;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    @Override
    public String toString() {
        return "*\nСайт\n" +
                "   Название: '" + getTitle() + '\'' +
                "\n    Тип страницы: '" + getType() + '\'' +
                "\n    Эл. ящик: " + getEmail() +
                "\n    Новости: " + getNews() +
                "\n    Информация бесплатна: " + getFree() +
                "\n    Обязательная авторизация: " + getAuthorize() +
                "\n*";
    }
}
