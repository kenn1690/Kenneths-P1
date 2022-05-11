package Models;

/**
 * Made these an enum as these are the only two role types required by client.
 * These two roles are also created in the DB and the table never gets written to
 */

public enum Role{

    EMPLOYEE {
        @Override
        public String toString() {
            return "Employee";
        }
    },
    FINANCE_MANAGER {
        @Override
        public String toString() {
            return "Finance Manager";
        }
    }

}
