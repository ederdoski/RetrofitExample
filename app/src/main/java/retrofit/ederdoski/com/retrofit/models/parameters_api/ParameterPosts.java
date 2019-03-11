package retrofit.ederdoski.com.retrofit.models.parameters_api;

public class ParameterPosts {

    private String name;
    private String job;

    public ParameterPosts(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

}
