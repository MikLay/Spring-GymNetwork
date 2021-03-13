package com.spp.gym_network.mainservice.dto;

public class JsonViews {

   /* public static final Map<ERoles, Class> MAPPING = new HashMap<>();

    static {
        MAPPING.put(ERoles.ROLE_USER, User.class);
        MAPPING.put(ERoles.ROLE_CLIENT, Client.class);
        MAPPING.put(ERoles.ROLE_COACH, Coach.class);
        MAPPING.put(ERoles.ROLE_MANAGER, Manager.class);
        MAPPING.put(ERoles.ROLE_ANONYMOUS, Anonymous.class);
    }*/

    public static interface Summary {
    }

    public static interface Detailed extends Summary {
    }

   /* public static interface User extends Summary {
    }

    public static interface Client extends User {
    }

    public static interface Coach extends User {
    }

    public static interface Manager extends User {
    }

    public static class Anonymous {

    }*/
}


