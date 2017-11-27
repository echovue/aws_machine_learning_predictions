package com.echovue.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Customer {
    private Long age;
    private String job;
    private String marital;
    private String education;
    private String def;
    private String housing;
    private String loan;
    private String contact;
    private String month;
    private String dayOfWeek;
    private Long duration;
    private Long campaign;
    private Long pDays;
    private Boolean previous;
    private String pOutcome;
    private Double empVarRate;
    private Double consPriceIdx;
    private Double consConfIdx;
    private Double euribor3m;
    private Double nrEmployed;

    @JsonGetter("age")
    public Long getAge() {
        return age;
    }

    @JsonSetter("age")
    public void setAge(final Long age) {
        this.age = age;
    }

    @JsonGetter("job")
    public String getJob() {
        return job;
    }

    @JsonSetter("job")
    public void setJob(final String job) {
        this.job = job;
    }

    @JsonGetter("marital")
    public String getMarital() {
        return marital;
    }

    @JsonSetter("marital")
    public void setMarital(final String marital) {
        this.marital = marital;
    }

    @JsonGetter("education")
    public String getEducation() {
        return education;
    }

    @JsonSetter("education")
    public void setEducation(final String education) {
        this.education = education;
    }

    @JsonGetter("default")
    public String getDefault() {
        return def;
    }

    @JsonSetter("default")
    public void setDefault(final String def) {
        this.def = def;
    }

    @JsonGetter("housing")
    public String getHousing() {
        return housing;
    }

    @JsonSetter("housing")
    public void setHousing(final String housing) {
        this.housing = housing;
    }

    @JsonGetter("loan")
    public String getLoan() {
        return loan;
    }

    @JsonSetter("loan")
    public void setLoan(final String loan) {
        this.loan = loan;
    }

    @JsonGetter("contact")
    public String getContact() {
        return contact;
    }

    @JsonSetter("contact")
    public void setContact(final String contact) {
        this.contact = contact;
    }

    @JsonGetter("month")
    public String getMonth() {
        return month;
    }

    @JsonSetter("month")
    public void setMonth(final String month) {
        this.month = month;
    }

    @JsonGetter("dayOfWeek")
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonSetter("dayOfWeek")
    public void setDayOfWeek(final String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @JsonGetter("duration")
    public Long getDuration() {
        return duration;
    }

    @JsonSetter("duration")
    public void setDuration(final Long duration) {
        this.duration = duration;
    }

    @JsonGetter("campaign")
    public Long getCampaign() {
        return campaign;
    }

    @JsonSetter("campaign")
    public void setCampaign(final Long campaign) {
        this.campaign = campaign;
    }

    @JsonGetter("pdays")
    public Long getPDays() {
        return pDays;
    }

    @JsonSetter("pdays")
    public void setPDays(final Long pDays) {
        this.pDays = pDays;
    }

    @JsonGetter("previous")
    public Integer getPrevious() {
        if (previous) {
            return 0;
        } else {
            return 1;
        }
    }

    @JsonSetter("previous")
    public void setPrevious(final Integer previous) {
        if (previous.equals(1)) {
            this.previous = false;
        } else {
            this.previous = true;
        }
    }

    @JsonGetter("poutcome")
    public String getPOutcome() {
        return pOutcome;
    }

    @JsonSetter("poutcome")
    public void setPOutcome(final String pOutcome) {
        this.pOutcome = pOutcome;
    }

    @JsonGetter("emp_var_rate")
    public Double getEmpVarRate() {
        return empVarRate;
    }

    @JsonSetter("emp_var_rate")
    public void setEmpVarRate(final Double empVarRate) {
        this.empVarRate = empVarRate;
    }

    @JsonGetter("cons_price_idx")
    public Double getConsPriceIdx() {
        return consPriceIdx;
    }

    @JsonSetter("cons_price_idx")
    public void setConsPriceIdx(final Double consPriceIdx) {
        this.consPriceIdx = consPriceIdx;
    }

    @JsonGetter("cons_conf_idx")
    public Double getConsConfIdx() {
        return consConfIdx;
    }

    @JsonSetter("cons_conf_idx")
    public void setConsConfIdx(final Double consConfIdx) {
        this.consConfIdx = consConfIdx;
    }

    @JsonGetter("euribor3m")
    public Double getEuribor3m() {
        return euribor3m;
    }

    @JsonSetter("euribor3m")
    public void setEuribor3m(final Double euribor3m) {
        this.euribor3m = euribor3m;
    }

    @JsonGetter("nr_employed")
    public Double getNrEmployed() {
        return nrEmployed;
    }

    @JsonSetter("nr_employed")
    public void setNrEmployed(final Double nrEmployed) {
        this.nrEmployed = nrEmployed;
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "Unable to convert object to JSON";
    }
}
