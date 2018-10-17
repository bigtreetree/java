package aaron.cheng.mybatis.entry;

public class ChildSettingEntry {

    private boolean ApproveFriendFlag; // 自动添加好友
    private boolean EyeshieldPatternFlag; // 护眼模式开关
    private String EyeshieldStartTime; // 护眼模式开始时间
    private String EyeshieldEndTime; // 护眼模式结束时间
    private boolean CallWhiteListFlag; // 白名单开关
    private boolean SMSFlag; // 短信开关
    private boolean TraceUploadFlag; // 单点多点轨迹是否上传开关[0-flase-关，1-true-开]
    private boolean SyncWarningFlag; // 预警同步标志[0-false-未同步, 1-true-已同步]

    public boolean getApproveFriendFlag() {
        return ApproveFriendFlag;
    }

    public void setApproveFriendFlag(boolean approveFriendFlag) {
        ApproveFriendFlag = approveFriendFlag;
    }

    public boolean getEyeshieldPatternFlag() {
        return EyeshieldPatternFlag;
    }

    public void setEyeshieldPatternFlag(boolean eyeshieldPatternFlag) {
        EyeshieldPatternFlag = eyeshieldPatternFlag;
    }

    public String getEyeshieldStartTime() {
        return EyeshieldStartTime;
    }

    public void setEyeshieldStartTime(String eyeshieldStartTime) {
        EyeshieldStartTime = eyeshieldStartTime;
    }

    public String getEyeshieldEndTime() {
        return EyeshieldEndTime;
    }

    public void setEyeshieldEndTime(String eyeshieldEndTime) {
        EyeshieldEndTime = eyeshieldEndTime;
    }

    public boolean getCallWhiteListFlag() {
        return CallWhiteListFlag;
    }

    public void setCallWhiteListFlag(boolean callWhiteListFlag) {
        CallWhiteListFlag = callWhiteListFlag;
    }

    public boolean getSMSFlag() {
        return SMSFlag;
    }

    public void setSMSFlag(boolean smsFlag) {
        SMSFlag = smsFlag;
    }

    public boolean getTraceUploadFlag() {
        return TraceUploadFlag;
    }

    public void setTraceUploadFlag(boolean traceUploadFlag) {
        TraceUploadFlag = traceUploadFlag;
    }

    public boolean getSyncWarningFlag() {
        return SyncWarningFlag;
    }

    public void setSyncWarningFlag(boolean syncWarningFlag) {
        SyncWarningFlag = syncWarningFlag;
    }

}
