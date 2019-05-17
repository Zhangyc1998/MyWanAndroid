package com.lzq.wanandroid.Contract;

import com.lzq.wanandroid.BaseView;
import com.lzq.wanandroid.Model.Data;
import com.lzq.wanandroid.Model.Datas;

import java.util.List;

public interface Contract {

    /**************************Activity***************************/

    interface MainPresenter {
        void isLogin();
    }

    interface MainView extends BaseView<Contract.MainPresenter> {
        void afterCheckLogin(boolean flag);
    }

    interface SettingPresenter {
        void changeDisplayMode(boolean flag);

        void Logout();
    }

    interface SettingView extends BaseView<Contract.SettingPresenter> {
        void afterChangeMode();

        void afterLogout();
    }

    interface SearchPresenter {
        void getHotKey();
    }

    interface SearchView extends BaseView<Contract.SearchPresenter> {
        void setHotKey(String[] keys);
    }

    /**************************Fragment***************************/
    interface HomePresenter {
        //与M层交互
        //获取文章前先使用占位符填充
        void initView();

        //获取玩安卓置顶文章
        void getHomeTopArticle();

        //获取玩安卓顶部图片
        void getHomeTopImgBanner();

        void getSelectedURL(String URL);

        void collectArticle(int ID, boolean isCollect, int position);

    }

    interface HomeView extends BaseView<Contract.HomePresenter> {
        //与V层交互，需要将获取的信息展示出来
        void setEmptyTopArticle(List<Data> mList);

        void setHomeTopArticle(List<Data> mList);

        void setHomeTopImgBanner(List<Data> mList);

        void goWebActivity(String URL);

        boolean onFinishLoad();

        void collectedArticle(int position, boolean isCollect);
    }

    interface UserPresenter {
        void initView();

        void initTabView();
    }

    interface UserView extends BaseView<Contract.UserPresenter> {
        void setUserInfo(String id, String username);

        void setTabView(String[] tabName, int[] imgTab);
    }

    interface CollectPresenter {
        void initView();

        void getCollectList();

        void getSelectedURL(String URL);

        void cancelCollect(int ID, int originID, int position);
    }

    interface CollectView extends BaseView<Contract.CollectPresenter> {
        void setEmptyList(List<Datas> mList);

        void setCollectList(List<Datas> mList);

        void goWebActivity(String URL);

        void removeItem(int position);

        boolean onFinishLoad();
    }

    interface ToDoPresenter {
    }

    interface ToDoView extends BaseView<Contract.ToDoPresenter> {

    }
}