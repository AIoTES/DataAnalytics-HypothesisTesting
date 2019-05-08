package eu.activage.services.web.rest.vm;

public class DataDesc {

    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "DataDesc{" +
            "query='" + query + '\'' +
            '}';
    }
}
