import com.sustain.cases.model.Charge
import com.sustain.util.DateUtil;

def Charge charge = _charge;
if (charge.cf_exceptionalClearDate != null && charge.chargeDate != null)
    if (DateUtil.isBefore(charge.cf_exceptionalClearDate, charge.chargeDate)) {
//        throw new Exception("Exceptional Clearance Date must be on or after chargeDate");
        addError("Exceptional Clearance Date must be on or after chargeDate", true)
    }