package net.CCweb;
import java.util.ArrayList;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.search.EntitySearcher;

public class CCOntology {

	public CCOntology() {
		super();
		// TODO Auto-generated constructor stub
	}
public static ArrayList<String> getSleepIssues() throws OWLOntologyCreationException {
		
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		IRI pizzaontology = IRI.create("https://raw.githubusercontent.com/nadaelarabyy/Character/master/Ontologies/V11RulesforFacets.owl");
		OWLOntology ontology=man.loadOntology(pizzaontology);
		
		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		reasoner.precomputeInferences();
		
       ArrayList<String> listClasses=new ArrayList<String>();
		for(OWLClass allclasses:ontology.getClassesInSignature()){
			
		   if(allclasses.toStringID().indexOf("DOID_535")>0 ||allclasses.toStringID().indexOf("MFOMD_0000024")>0){
			   for(Node<OWLClass> e:reasoner.getSubClasses(allclasses, false)) {
				   for(OWLClass e1:e.getEntities()) {
					   if(e1.getIRI().toString().contains("#")) {
						   if(e1.getIRI().getShortForm().toString().contains("_"))
				            listClasses.add(e1.getIRI().getShortForm().toString().replace("_", " "));
						   else
							   listClasses.add(e1.getIRI().getShortForm().toString());
							   
							   

						   
					   }
					   else {
						   OWLDataFactory dataFactory = man.getOWLDataFactory();
			   				EntitySearcher.getAnnotations(e1, ontology, dataFactory.getRDFSLabel()).forEach(annotation -> {
			                    OWLAnnotationProperty property = annotation.getProperty();
			                    
			                    OWLLiteral literal = (OWLLiteral) annotation.getValue();
			                    listClasses.add(literal.getLiteral());
			                   
			                    
			                });
						   
					   }
				   }
				   
				   
				   
			   }

		   }
		}
		return listClasses;

		
	}

	public static ArrayList<String> getBehbaviors() throws OWLOntologyCreationException {
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		IRI pizzaontology = IRI.create("https://raw.githubusercontent.com/nadaelarabyy/Character/master/Ontologies/V11RulesforFacets.owl");
		OWLOntology ontology=man.loadOntology(pizzaontology);
		
		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		reasoner.precomputeInferences();
		
       ArrayList<String> listClasses=new ArrayList<String>();
		for(OWLClass allclasses:ontology.getClassesInSignature()){
		   if(allclasses.toStringID().indexOf("GO_0007610")>0){
			   for(Node<OWLClass> e:reasoner.getSubClasses(allclasses, false)) {
				   for(OWLClass e1:e.getEntities()) {
					   if(e1.getIRI().toString().contains("#")) {
						   if(e1.getIRI().getShortForm().toString().contains("_"))
				            listClasses.add(e1.getIRI().getShortForm().toString().replace("_", " "));
						   else
							   listClasses.add(e1.getIRI().getShortForm().toString());
							   
							   

						   
					   }
					   else {
						   OWLDataFactory dataFactory = man.getOWLDataFactory();
			   				EntitySearcher.getAnnotations(e1, ontology, dataFactory.getRDFSLabel()).forEach(annotation -> {
			                    OWLAnnotationProperty property = annotation.getProperty();
			                    
			                    OWLLiteral literal = (OWLLiteral) annotation.getValue();
			                    listClasses.add(literal.getLiteral());
			                   
			                    
			                });
						   
					   }
				   }
				   
				   
				   
			   }

		   }
		}
		return listClasses;
		
	}

	public static ArrayList<String> getEmotions() throws OWLOntologyCreationException {
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		IRI pizzaontology = IRI.create("https://raw.githubusercontent.com/nadaelarabyy/Character/master/Ontologies/V11RulesforFacets.owl");
		OWLOntology ontology=man.loadOntology(pizzaontology);
		
		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		reasoner.precomputeInferences();
		
       ArrayList<String> listClasses=new ArrayList<String>();
		for(OWLClass allclasses:ontology.getClassesInSignature()){
			
		   if(allclasses.toStringID().indexOf("MFOEM_000195")>0||allclasses.toStringID().indexOf("MFOEM_000003")>0){
			   for(Node<OWLClass> e:reasoner.getSubClasses(allclasses, false)) {
				   for(OWLClass e1:e.getEntities()) {
					   if(e1.getIRI().toString().contains("#")) {
						   
				            listClasses.add(e1.getIRI().getShortForm().toString());

						   
					   }
					   else {
						   OWLDataFactory dataFactory = man.getOWLDataFactory();
			   				EntitySearcher.getAnnotations(e1, ontology, dataFactory.getRDFSLabel()).forEach(annotation -> {
			                    OWLAnnotationProperty property = annotation.getProperty();
			                    
			                    OWLLiteral literal = (OWLLiteral) annotation.getValue();
			                    listClasses.add(literal.getLiteral());
			                   
			                    
			                });
						   
					   }
				   }
				   
				   
				   
			   }

		   }
		}
		return listClasses;
		


		
		
	}

	public static ArrayList<String> getPersonality() throws OWLOntologyCreationException {
		OWLOntologyManager man = OWLManager.createOWLOntologyManager();
		IRI pizzaontology = IRI.create("https://raw.githubusercontent.com/nadaelarabyy/Character/master/Ontologies/V11RulesforFacets.owl");
		OWLOntology ontology=man.loadOntology(pizzaontology);
		
		OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
		ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
		OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
		OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
		reasoner.precomputeInferences();
		
       ArrayList<String> listClasses=new ArrayList<String>();
		for(OWLClass allclasses:ontology.getClassesInSignature()){
			
		   if(allclasses.toStringID().indexOf("Human")>0){
			   for(Node<OWLClass> e:reasoner.getSubClasses(allclasses, false)) {
				   for(OWLClass e1:e.getEntities()) {
					   if(e1.getIRI().toString().contains("#")) {
						   
				            listClasses.add(e1.getIRI().getShortForm().toString());

						   
					   }
					   else {
						   OWLDataFactory dataFactory = man.getOWLDataFactory();
			   				EntitySearcher.getAnnotations(e1, ontology, dataFactory.getRDFSLabel()).forEach(annotation -> {
			                    OWLAnnotationProperty property = annotation.getProperty();
			                    
			                    OWLLiteral literal = (OWLLiteral) annotation.getValue();
			                    listClasses.add(literal.getLiteral());
			                   
			                    
			                });
						   
					   }
				   }
				   
				   
				   
			   }

		   }
		}
		return listClasses;
		
		
		
	}


public static void main(String[] args) throws OWLOntologyCreationException {
	CCOntology o=new CCOntology();
	System.out.println(o.getBehbaviors().toString());
}
}
