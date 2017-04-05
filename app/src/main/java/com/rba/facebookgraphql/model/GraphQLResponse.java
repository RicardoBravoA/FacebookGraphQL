package com.rba.facebookgraphql.model;

/**
 * Created by ricardo on 05/04/17.
 */

public class GraphQLResponse {

    /**
     * nameValuePairs : {"name":"Ricardo Bravo","email":"richard90_15@hotmail.com","first_name":"Ricardo","gender":"male","id":"1369376933127646","cover":{"nameValuePairs":{"id":"762476033817742","offset_y":60,"source":"https://scontent.xx.fbcdn.net/v/t1.0-9/10698663_762476033817742_7474460627441864421_n.jpg?oh=bf486b0230ecdc26b3368130d84ec9f6&oe=594DAB04"}},"last_name":"Bravo"}
     */

    private NameValuePairsBeanX nameValuePairs;

    public NameValuePairsBeanX getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(NameValuePairsBeanX nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public static class NameValuePairsBeanX {
        /**
         * name : Ricardo Bravo
         * email : richard90_15@hotmail.com
         * first_name : Ricardo
         * gender : male
         * id : 1369376933127646
         * cover : {"nameValuePairs":{"id":"762476033817742","offset_y":60,"source":"https://scontent.xx.fbcdn.net/v/t1.0-9/10698663_762476033817742_7474460627441864421_n.jpg?oh=bf486b0230ecdc26b3368130d84ec9f6&oe=594DAB04"}}
         * last_name : Bravo
         */

        private String name;
        private String email;
        private String first_name;
        private String gender;
        private String id;
        private CoverBean cover;
        private String last_name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public static class CoverBean {
            /**
             * nameValuePairs : {"id":"762476033817742","offset_y":60,"source":"https://scontent.xx.fbcdn.net/v/t1.0-9/10698663_762476033817742_7474460627441864421_n.jpg?oh=bf486b0230ecdc26b3368130d84ec9f6&oe=594DAB04"}
             */

            private NameValuePairsBean nameValuePairs;

            public NameValuePairsBean getNameValuePairs() {
                return nameValuePairs;
            }

            public void setNameValuePairs(NameValuePairsBean nameValuePairs) {
                this.nameValuePairs = nameValuePairs;
            }

            public static class NameValuePairsBean {
                /**
                 * id : 762476033817742
                 * offset_y : 60
                 * source : https://scontent.xx.fbcdn.net/v/t1.0-9/10698663_762476033817742_7474460627441864421_n.jpg?oh=bf486b0230ecdc26b3368130d84ec9f6&oe=594DAB04
                 */

                private String id;
                private int offset_y;
                private String source;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public int getOffset_y() {
                    return offset_y;
                }

                public void setOffset_y(int offset_y) {
                    this.offset_y = offset_y;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }
            }
        }
    }
}
