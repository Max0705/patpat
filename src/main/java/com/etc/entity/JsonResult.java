package com.etc.entity;

import java.util.List;

import com.github.pagehelper.PageInfo;

public class JsonResult<T> {

    private static final int SUCCESS=0;

    //当前返回数据的状态。成功为0，失败为其他数字。
    private int state;
    private String message="";
    private T data;
    private List<T> datas;
    private PageInfo<T> pagedatas;

    //专门提供给客户端表格插件bootstrap-table适配
    private long total;
    private List<T> rows;


    //操作成功
    public JsonResult(String message){
        this.state = SUCCESS;
        this.message = message;
    }

    public JsonResult(T data){
        this.state = SUCCESS;
        this.data = data;
    }

    public JsonResult(T data,String message){
        this.state = SUCCESS;
        this.data = data;
        this.message = message;
    }

    public JsonResult(List<T> datas){
        this.state = SUCCESS;
        this.datas = datas;
    }

    public JsonResult(List<T> datas,String message){
        this.state = SUCCESS;
        this.datas = datas;
        this.message = message;
    }

    public JsonResult(PageInfo<T> pagedatas){
        this.state = SUCCESS;
        this.pagedatas = pagedatas;
    }

    public JsonResult(PageInfo<T> pagedatas,String message){
        this.state = SUCCESS;
        this.pagedatas = pagedatas;
        this.message = message;
    }

    //操作失败
    public JsonResult(int state,String message){
        this.state = state;
        this.message = message;
    }



    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public List<T> getDatas() {
        return datas;
    }
    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
    public PageInfo<T> getPagedatas() {
        return pagedatas;
    }
    public void setPagedatas(PageInfo<T> pagedatas) {
        this.pagedatas = pagedatas;
    }

    public long getTotal(){
        return pagedatas!=null?pagedatas.getTotal():0;
    }
    public List<T> getRows(){
        return pagedatas!=null?pagedatas.getList():null;
    }

}
