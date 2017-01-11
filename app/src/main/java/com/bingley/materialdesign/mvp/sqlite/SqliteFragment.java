package com.bingley.materialdesign.mvp.sqlite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bingley.materialdesign.R;
import com.bingley.materialdesign.base.BaseFragment;
import com.bingley.materialdesign.mvp.sqlite.dao.ContactInfoDao;

import butterknife.Bind;

/**
 * 原生的sqlite操作  ---也得具备数据库知识才行
 * 框架级的sqlite操作
 * 还有一种是直接用文件来存取(shereperfenrence,它也是可以用来存对象的)
 * Author:  Mr.bingley
 * Version:
 * Date:  2017/1/11
 */

public class SqliteFragment extends BaseFragment {
    @Bind(R.id.et_name)
    EditText mEtName;
    @Bind(R.id.et_phone)
    EditText mEtPhone;

    private ContactInfoDao dao;
    private Context mActivity;

    @Override
    protected int getLayoutId() {
        return R.layout.frg_sqlite;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        dao = new ContactInfoDao(getActivity());
        mActivity = getActivity();
    }


    /**
     * 添加一条联系人的信息
     * @param view
     */
    public void add(View view) {
        String name = mEtName.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
            Toast.makeText(mActivity, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            dao.add(name, phone);
            Toast.makeText(mActivity, "添加成功", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 删除一条记录
     * @param view
     */
    public void delete(View view){
        String name = mEtName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(mActivity, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            dao.delete(name);
            Toast.makeText(mActivity, "删除成功", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     *  修改联系人的号码
     * @param view
     */
    public void update(View view){
        String name = mEtName.getText().toString().trim();
        String phone = mEtPhone.getText().toString().trim();
        if(TextUtils.isEmpty(name)||TextUtils.isEmpty(phone)){
            Toast.makeText(mActivity, "不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            dao.update(phone, name);
            Toast.makeText(mActivity, "修改成功", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 查询
     * @param view
     */
    public void query(View view){
        String name = mEtName.getText().toString().trim();
        if(TextUtils.isEmpty(name)){
            Toast.makeText(mActivity, "姓名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            String result = dao.getPhoneNumber(name);
            Toast.makeText(mActivity, "号码:"+result, Toast.LENGTH_SHORT).show();
        }
    }
}
