package com.xspace.ui.template;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xspace.module.BaseModule;
import com.xspace.module.TemplateModule;
import com.xspace.ui.jumputils.AddressManager;
import com.xspace.ui.jumputils.CategoryUtil;
import com.xspace.utils.DisplayUtil;

import demo.pplive.com.xspace.R;

public class TemplateSearch extends BaseView
{
    public String TAG = "template_search";

    private View mRootView;

    private EditText editText;

    public TemplateSearch(Context context)
    {
        super(context);
        initView();
    }

    private void initView()
    {
        mRootView = View.inflate(mContext, R.layout.view_searchbar, null);
        mRootView.setLayoutParams(new LayoutParams(-1, (int) (45 * DisplayUtil.getDensity(mContext))));
        editText = mRootView.findViewById(R.id.search_txt);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == 0 && module instanceof TemplateModule)
                {
                    ((TemplateModule) module).tag = editText.getText().toString();
                    ((TemplateModule) module).type = CategoryUtil.TypeNative;
                    ((TemplateModule) module).link = AddressManager.Native_Search;
                    onItemClick(module);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void setData(BaseModule module)
    {
        if (module == null || !(module instanceof TemplateModule))
        {
            return;
        }
        this.module = module;
        fillData(module);
    }

    @Override
    public void fillData(BaseModule module)
    {
        if (module instanceof TemplateModule)
        {
            editText.setHint(((TemplateModule) module).title == null ? "搜索" : ((TemplateModule) module).title);
        }
        addTemplateView();
    }

    @Override
    public void addTemplateView()
    {
        addView(mRootView);
    }

    @Override
    public void reFresh()
    {

    }

}