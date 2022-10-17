package org.example.contrller;

@Component
public class SpringSecurityEventListener {

    @EventListener(InteractiveAuthenticationSuccessEvent.class)
    public void authenticationSuccessEventListener(InteractiveAuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        System.out.println(authentication.getName());
    }
}