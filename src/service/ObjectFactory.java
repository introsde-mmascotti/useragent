
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SavePerson_QNAME = new QName("http://service/", "savePerson");
    private final static QName _SaveMeasureResponse_QNAME = new QName("http://service/", "saveMeasureResponse");
    private final static QName _FindIngredient_QNAME = new QName("http://service/", "findIngredient");
    private final static QName _SaveHealthprofileResponse_QNAME = new QName("http://service/", "saveHealthprofileResponse");
    private final static QName _SaveRecipeResponse_QNAME = new QName("http://service/", "saveRecipeResponse");
    private final static QName _AddRecipeIngredient_QNAME = new QName("http://service/", "addRecipeIngredient");
    private final static QName _GetPerson_QNAME = new QName("http://service/", "getPerson");
    private final static QName _RemoveRecipeIngredientResponse_QNAME = new QName("http://service/", "removeRecipeIngredientResponse");
    private final static QName _SaveMeasure_QNAME = new QName("http://service/", "saveMeasure");
    private final static QName _GetMeasureResponse_QNAME = new QName("http://service/", "getMeasureResponse");
    private final static QName _SaveHealthprofile_QNAME = new QName("http://service/", "saveHealthprofile");
    private final static QName _SavePersonResponse_QNAME = new QName("http://service/", "savePersonResponse");
    private final static QName _GetMeasureHistoryResponse_QNAME = new QName("http://service/", "getMeasureHistoryResponse");
    private final static QName _AddRecipeIngredientResponse_QNAME = new QName("http://service/", "addRecipeIngredientResponse");
    private final static QName _GetHealthprofileResponse_QNAME = new QName("http://service/", "getHealthprofileResponse");
    private final static QName _FindIngredientResponse_QNAME = new QName("http://service/", "findIngredientResponse");
    private final static QName _GetHealthprofile_QNAME = new QName("http://service/", "getHealthprofile");
    private final static QName _FindRecipe_QNAME = new QName("http://service/", "findRecipe");
    private final static QName _FindRecipeResponse_QNAME = new QName("http://service/", "findRecipeResponse");
    private final static QName _GetPersonResponse_QNAME = new QName("http://service/", "getPersonResponse");
    private final static QName _RemoveRecipeIngredient_QNAME = new QName("http://service/", "removeRecipeIngredient");
    private final static QName _GetHealthAdvice_QNAME = new QName("http://service/", "getHealthAdvice");
    private final static QName _GetMeasure_QNAME = new QName("http://service/", "getMeasure");
    private final static QName _GetMeasureHistory_QNAME = new QName("http://service/", "getMeasureHistory");
    private final static QName _ReplaceRecipeIngredient_QNAME = new QName("http://service/", "replaceRecipeIngredient");
    private final static QName _GetHealthAdviceResponse_QNAME = new QName("http://service/", "getHealthAdviceResponse");
    private final static QName _SaveRecipe_QNAME = new QName("http://service/", "saveRecipe");
    private final static QName _ReplaceRecipeIngredientResponse_QNAME = new QName("http://service/", "replaceRecipeIngredientResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMeasureResponse }
     * 
     */
    public GetMeasureResponse createGetMeasureResponse() {
        return new GetMeasureResponse();
    }

    /**
     * Create an instance of {@link SaveHealthprofile }
     * 
     */
    public SaveHealthprofile createSaveHealthprofile() {
        return new SaveHealthprofile();
    }

    /**
     * Create an instance of {@link GetHealthprofile }
     * 
     */
    public GetHealthprofile createGetHealthprofile() {
        return new GetHealthprofile();
    }

    /**
     * Create an instance of {@link FindIngredientResponse }
     * 
     */
    public FindIngredientResponse createFindIngredientResponse() {
        return new FindIngredientResponse();
    }

    /**
     * Create an instance of {@link GetHealthprofileResponse }
     * 
     */
    public GetHealthprofileResponse createGetHealthprofileResponse() {
        return new GetHealthprofileResponse();
    }

    /**
     * Create an instance of {@link AddRecipeIngredientResponse }
     * 
     */
    public AddRecipeIngredientResponse createAddRecipeIngredientResponse() {
        return new AddRecipeIngredientResponse();
    }

    /**
     * Create an instance of {@link GetMeasureHistoryResponse }
     * 
     */
    public GetMeasureHistoryResponse createGetMeasureHistoryResponse() {
        return new GetMeasureHistoryResponse();
    }

    /**
     * Create an instance of {@link SavePersonResponse }
     * 
     */
    public SavePersonResponse createSavePersonResponse() {
        return new SavePersonResponse();
    }

    /**
     * Create an instance of {@link GetMeasureHistory }
     * 
     */
    public GetMeasureHistory createGetMeasureHistory() {
        return new GetMeasureHistory();
    }

    /**
     * Create an instance of {@link GetMeasure }
     * 
     */
    public GetMeasure createGetMeasure() {
        return new GetMeasure();
    }

    /**
     * Create an instance of {@link GetHealthAdvice }
     * 
     */
    public GetHealthAdvice createGetHealthAdvice() {
        return new GetHealthAdvice();
    }

    /**
     * Create an instance of {@link FindRecipeResponse }
     * 
     */
    public FindRecipeResponse createFindRecipeResponse() {
        return new FindRecipeResponse();
    }

    /**
     * Create an instance of {@link GetPersonResponse }
     * 
     */
    public GetPersonResponse createGetPersonResponse() {
        return new GetPersonResponse();
    }

    /**
     * Create an instance of {@link RemoveRecipeIngredient }
     * 
     */
    public RemoveRecipeIngredient createRemoveRecipeIngredient() {
        return new RemoveRecipeIngredient();
    }

    /**
     * Create an instance of {@link FindRecipe }
     * 
     */
    public FindRecipe createFindRecipe() {
        return new FindRecipe();
    }

    /**
     * Create an instance of {@link ReplaceRecipeIngredientResponse }
     * 
     */
    public ReplaceRecipeIngredientResponse createReplaceRecipeIngredientResponse() {
        return new ReplaceRecipeIngredientResponse();
    }

    /**
     * Create an instance of {@link SaveRecipe }
     * 
     */
    public SaveRecipe createSaveRecipe() {
        return new SaveRecipe();
    }

    /**
     * Create an instance of {@link GetHealthAdviceResponse }
     * 
     */
    public GetHealthAdviceResponse createGetHealthAdviceResponse() {
        return new GetHealthAdviceResponse();
    }

    /**
     * Create an instance of {@link ReplaceRecipeIngredient }
     * 
     */
    public ReplaceRecipeIngredient createReplaceRecipeIngredient() {
        return new ReplaceRecipeIngredient();
    }

    /**
     * Create an instance of {@link SaveHealthprofileResponse }
     * 
     */
    public SaveHealthprofileResponse createSaveHealthprofileResponse() {
        return new SaveHealthprofileResponse();
    }

    /**
     * Create an instance of {@link FindIngredient }
     * 
     */
    public FindIngredient createFindIngredient() {
        return new FindIngredient();
    }

    /**
     * Create an instance of {@link SaveMeasureResponse }
     * 
     */
    public SaveMeasureResponse createSaveMeasureResponse() {
        return new SaveMeasureResponse();
    }

    /**
     * Create an instance of {@link SavePerson }
     * 
     */
    public SavePerson createSavePerson() {
        return new SavePerson();
    }

    /**
     * Create an instance of {@link AddRecipeIngredient }
     * 
     */
    public AddRecipeIngredient createAddRecipeIngredient() {
        return new AddRecipeIngredient();
    }

    /**
     * Create an instance of {@link SaveRecipeResponse }
     * 
     */
    public SaveRecipeResponse createSaveRecipeResponse() {
        return new SaveRecipeResponse();
    }

    /**
     * Create an instance of {@link GetPerson }
     * 
     */
    public GetPerson createGetPerson() {
        return new GetPerson();
    }

    /**
     * Create an instance of {@link SaveMeasure }
     * 
     */
    public SaveMeasure createSaveMeasure() {
        return new SaveMeasure();
    }

    /**
     * Create an instance of {@link RemoveRecipeIngredientResponse }
     * 
     */
    public RemoveRecipeIngredientResponse createRemoveRecipeIngredientResponse() {
        return new RemoveRecipeIngredientResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "savePerson")
    public JAXBElement<SavePerson> createSavePerson(SavePerson value) {
        return new JAXBElement<SavePerson>(_SavePerson_QNAME, SavePerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveMeasureResponse")
    public JAXBElement<SaveMeasureResponse> createSaveMeasureResponse(SaveMeasureResponse value) {
        return new JAXBElement<SaveMeasureResponse>(_SaveMeasureResponse_QNAME, SaveMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findIngredient")
    public JAXBElement<FindIngredient> createFindIngredient(FindIngredient value) {
        return new JAXBElement<FindIngredient>(_FindIngredient_QNAME, FindIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveHealthprofileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveHealthprofileResponse")
    public JAXBElement<SaveHealthprofileResponse> createSaveHealthprofileResponse(SaveHealthprofileResponse value) {
        return new JAXBElement<SaveHealthprofileResponse>(_SaveHealthprofileResponse_QNAME, SaveHealthprofileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRecipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveRecipeResponse")
    public JAXBElement<SaveRecipeResponse> createSaveRecipeResponse(SaveRecipeResponse value) {
        return new JAXBElement<SaveRecipeResponse>(_SaveRecipeResponse_QNAME, SaveRecipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecipeIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addRecipeIngredient")
    public JAXBElement<AddRecipeIngredient> createAddRecipeIngredient(AddRecipeIngredient value) {
        return new JAXBElement<AddRecipeIngredient>(_AddRecipeIngredient_QNAME, AddRecipeIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerson }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getPerson")
    public JAXBElement<GetPerson> createGetPerson(GetPerson value) {
        return new JAXBElement<GetPerson>(_GetPerson_QNAME, GetPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRecipeIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeRecipeIngredientResponse")
    public JAXBElement<RemoveRecipeIngredientResponse> createRemoveRecipeIngredientResponse(RemoveRecipeIngredientResponse value) {
        return new JAXBElement<RemoveRecipeIngredientResponse>(_RemoveRecipeIngredientResponse_QNAME, RemoveRecipeIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveMeasure")
    public JAXBElement<SaveMeasure> createSaveMeasure(SaveMeasure value) {
        return new JAXBElement<SaveMeasure>(_SaveMeasure_QNAME, SaveMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeasureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMeasureResponse")
    public JAXBElement<GetMeasureResponse> createGetMeasureResponse(GetMeasureResponse value) {
        return new JAXBElement<GetMeasureResponse>(_GetMeasureResponse_QNAME, GetMeasureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveHealthprofile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveHealthprofile")
    public JAXBElement<SaveHealthprofile> createSaveHealthprofile(SaveHealthprofile value) {
        return new JAXBElement<SaveHealthprofile>(_SaveHealthprofile_QNAME, SaveHealthprofile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "savePersonResponse")
    public JAXBElement<SavePersonResponse> createSavePersonResponse(SavePersonResponse value) {
        return new JAXBElement<SavePersonResponse>(_SavePersonResponse_QNAME, SavePersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeasureHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMeasureHistoryResponse")
    public JAXBElement<GetMeasureHistoryResponse> createGetMeasureHistoryResponse(GetMeasureHistoryResponse value) {
        return new JAXBElement<GetMeasureHistoryResponse>(_GetMeasureHistoryResponse_QNAME, GetMeasureHistoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRecipeIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "addRecipeIngredientResponse")
    public JAXBElement<AddRecipeIngredientResponse> createAddRecipeIngredientResponse(AddRecipeIngredientResponse value) {
        return new JAXBElement<AddRecipeIngredientResponse>(_AddRecipeIngredientResponse_QNAME, AddRecipeIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHealthprofileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getHealthprofileResponse")
    public JAXBElement<GetHealthprofileResponse> createGetHealthprofileResponse(GetHealthprofileResponse value) {
        return new JAXBElement<GetHealthprofileResponse>(_GetHealthprofileResponse_QNAME, GetHealthprofileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findIngredientResponse")
    public JAXBElement<FindIngredientResponse> createFindIngredientResponse(FindIngredientResponse value) {
        return new JAXBElement<FindIngredientResponse>(_FindIngredientResponse_QNAME, FindIngredientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHealthprofile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getHealthprofile")
    public JAXBElement<GetHealthprofile> createGetHealthprofile(GetHealthprofile value) {
        return new JAXBElement<GetHealthprofile>(_GetHealthprofile_QNAME, GetHealthprofile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findRecipe")
    public JAXBElement<FindRecipe> createFindRecipe(FindRecipe value) {
        return new JAXBElement<FindRecipe>(_FindRecipe_QNAME, FindRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRecipeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findRecipeResponse")
    public JAXBElement<FindRecipeResponse> createFindRecipeResponse(FindRecipeResponse value) {
        return new JAXBElement<FindRecipeResponse>(_FindRecipeResponse_QNAME, FindRecipeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getPersonResponse")
    public JAXBElement<GetPersonResponse> createGetPersonResponse(GetPersonResponse value) {
        return new JAXBElement<GetPersonResponse>(_GetPersonResponse_QNAME, GetPersonResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveRecipeIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "removeRecipeIngredient")
    public JAXBElement<RemoveRecipeIngredient> createRemoveRecipeIngredient(RemoveRecipeIngredient value) {
        return new JAXBElement<RemoveRecipeIngredient>(_RemoveRecipeIngredient_QNAME, RemoveRecipeIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHealthAdvice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getHealthAdvice")
    public JAXBElement<GetHealthAdvice> createGetHealthAdvice(GetHealthAdvice value) {
        return new JAXBElement<GetHealthAdvice>(_GetHealthAdvice_QNAME, GetHealthAdvice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeasure }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMeasure")
    public JAXBElement<GetMeasure> createGetMeasure(GetMeasure value) {
        return new JAXBElement<GetMeasure>(_GetMeasure_QNAME, GetMeasure.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeasureHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getMeasureHistory")
    public JAXBElement<GetMeasureHistory> createGetMeasureHistory(GetMeasureHistory value) {
        return new JAXBElement<GetMeasureHistory>(_GetMeasureHistory_QNAME, GetMeasureHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplaceRecipeIngredient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "replaceRecipeIngredient")
    public JAXBElement<ReplaceRecipeIngredient> createReplaceRecipeIngredient(ReplaceRecipeIngredient value) {
        return new JAXBElement<ReplaceRecipeIngredient>(_ReplaceRecipeIngredient_QNAME, ReplaceRecipeIngredient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHealthAdviceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getHealthAdviceResponse")
    public JAXBElement<GetHealthAdviceResponse> createGetHealthAdviceResponse(GetHealthAdviceResponse value) {
        return new JAXBElement<GetHealthAdviceResponse>(_GetHealthAdviceResponse_QNAME, GetHealthAdviceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRecipe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveRecipe")
    public JAXBElement<SaveRecipe> createSaveRecipe(SaveRecipe value) {
        return new JAXBElement<SaveRecipe>(_SaveRecipe_QNAME, SaveRecipe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReplaceRecipeIngredientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "replaceRecipeIngredientResponse")
    public JAXBElement<ReplaceRecipeIngredientResponse> createReplaceRecipeIngredientResponse(ReplaceRecipeIngredientResponse value) {
        return new JAXBElement<ReplaceRecipeIngredientResponse>(_ReplaceRecipeIngredientResponse_QNAME, ReplaceRecipeIngredientResponse.class, null, value);
    }

}
