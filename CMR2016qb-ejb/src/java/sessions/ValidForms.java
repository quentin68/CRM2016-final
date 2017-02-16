/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

/**
 *
 * @author deptinfo
 */
public class ValidForms {        

    /**
     *
     * @param tel
     * @throws Exception
     */
    public static void validationTelephone(String tel) throws Exception {
        if(tel != null && tel.trim().length() != 0) {
            if(!tel.matches("^[0-9]{10}$")) {
                throw new Exception("Merci de saisir un numéro valide.");
            }
        }
        else {
            throw new Exception("Merci de saisir un numéro valide.");
        }
    }

    /**
     *
     * @param email
     * @throws Exception
     */
    public static void validationEmail(String email) throws Exception {
        if(email != null && email.trim().length() != 0) {
            if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        }
        else {
            throw new Exception("Merci de saisir une adresse mail valide.");
        }
    }

    /**
     *
     * @param motDePasse
     * @param confirmation
     * @throws Exception
     */
    public static void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
        if(motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null && confirmation.trim().length() != 0) {
            if(!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents.");
            }
            else if(motDePasse.trim().length() < 6) {
                throw new Exception("Les mots de passe doivent contenir au moins 6 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }
    
    /**
     *
     * @param text
     * @throws Exception
     */
    public static void validationText(String text) throws Exception {
        if(text != null && text.trim().length() < 3) {
            throw new Exception("Veuillez saisir au moins 3 caractères.");
        }
    }
         
    /**
     *
     * @param d
     * @throws Exception
     */
    public static void validationDouble(String d) throws Exception {
        if(d != null) {
            try {
                Double.parseDouble(d);
            }
            catch(Exception e) {    
                throw new Exception("Veuillez saisir un nombre.");
            }
            
            if(d.equals("0")) {
                throw new Exception("Veuillez saisir un nombre différent de 0.");
            }
        }
        else {
            throw new Exception("Veuillez saisir un nombre.");
        }
    }
    
    /**
     *
     * @param select
     * @throws Exception
     */
    public static void validationSelect(String select) throws Exception {
        if(select != null && select.equals("0")) {
            throw new Exception("Veuillez choisir un élément dans la liste.");
        }
    }
}
