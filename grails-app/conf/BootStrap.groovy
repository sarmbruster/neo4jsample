class BootStrap {

    def init = { servletContext ->

        /*User.withTransaction {
            log.debug "creating sample data..."
            User admin = new User(name: "AdminUser").save()
            log.debug "${admin.name} user created"
            User sam = new User(name: "sam", createdBy: admin).save()
            log.debug "${sam.name} user created"

            Role admrole = new Role(name: "admin", createdBy: admin).save()
            admin.addToRoles(admrole)
            Role usrRole = new Role(name: "usr", createdBy: admin).save()
            sam.addToRoles(usrRole)
        }*/
    }

}
