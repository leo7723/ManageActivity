/**
 * Created by changliliao on 2017/3/28.
 */
public class BaseApplication extends Application{
        @Override
        public void onCreate() {
            super.onCreate();
            instance = this;
        }
        /**already opened activity**/
        private List<Activity> activities = new ArrayList<Activity>();
        /** instance **/
        private static BaseApplication instance;
        /**
         * get Instance
         * @return
         */
        public static BaseApplication getInstance(){
            return instance;
        }
        /**
         * add new activity
         * @param activity
         */
        public void addActivity(Activity activity){
            activities.add(activity);
        }
        /**
         *  close an aiming Activity
         * @param activity
         */
        public void finishActivity(Activity activity){
            if (activity!=null) {
                this.activities.remove(activity);
                activity.finish();
                activity = null;
            }
        }
        /**
         * exit app and close all activity
         */
        public void exit(){
            for (Activity activity : activities) {
                if (activity!=null) {
                    activity.finish();
                }
            }
            System.exit(0);
        }
        /**
         * close activities in list*/
        public void finishActivity(){
            for (Activity activity : activities) {
                if (null != activity) {
                    activity.finish();
                }
            }
            //kill app process
            android.os.Process.killProcess(android.os.Process.myPid());
        }
}
