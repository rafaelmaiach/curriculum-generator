package br.unesp.rc.curriculumGenerator.model;

/**
 * This class represents the Professional Experiences of the curriculum owner
 * Some company they've worked and which was their job
 */
public class ProfessionalExperience {

    private String job;

    private String startDate;

    private String finalDate;

    private String company;

    private String location;

    private String jobDescription;

    public ProfessionalExperience() {

    }

    /**
     * @return the job name
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets the job name
     *
     * @param job the job name
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * @return the experience start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the experience start date
     * @param startDate the experience start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the experience final date
     */
    public String getFinalDate() {
        return finalDate;
    }

    /**
     * Sets the experience finak date
     * @param finalDate
     */
    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    /**
     * @return the company name
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the company name
     * @param company the company name
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the company location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the company location
     * @param location the company location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the job description
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Sets the job description
     * @param jobDescription the job description
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

}
