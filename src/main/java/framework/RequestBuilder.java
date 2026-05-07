
package framework;

public class RequestBuilder {

    public static ControlRequest build(
            int formId,
            String userId,
            String controlId,
            ControlRequest.Changes changes
    ) {

        ControlRequest req = new ControlRequest();

        req.form_id = formId;
        req.user_id = userId;

        changes.CONTROL_ID = controlId;

        req.changes = changes;

        return req;
    }
}