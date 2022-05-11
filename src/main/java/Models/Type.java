package Models;

/**
 * Made these an enum as these are the only four reimbursement types required by client.
 * These four reimbursement types are also created in the DB and the table never gets written to
 */

public enum Type {
    TRANSPORTATION {
        @Override
        public String toString() {
            return "Transportation";
        }
    },
    FOOD {
        @Override
        public String toString() {
            return "Food";
        }
    },
    LODGING {
        @Override
        public String toString() {
            return "Lodging";
        }
    },
    MISCELLANEOUS {
        @Override
        public String toString() {
            return "Miscellaneous";
        }
    },
}
