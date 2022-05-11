package Models;

/**
 * Made these an enum as these are the only three status types required by client.
 * These three status types are also created in the DB and the table never gets written to
 */

public enum Status {
    PENDING {
        @Override
        public String toString() {
            return "Pending";
        }
    },
    APPROVED {
        @Override
        public String toString() {
            return "Approved";
        }
    },
    DENIED {
        @Override
        public String toString() {
            return "Denied";
        }
    }
}
