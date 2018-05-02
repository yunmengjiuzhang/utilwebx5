package wangfei.utilwebx5;

        import com.tencent.smtt.sdk.DownloadListener;
        import com.tencent.smtt.utils.TbsLog;

public class X5DownLoadListener implements DownloadListener {
    @Override
    public void onDownloadStart(String arg0, String arg1, String arg2,
                                String arg3, long arg4) {
        TbsLog.d("BaseX5WebActivity", "url: " + arg0);
    }
}
