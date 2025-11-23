package com.example.openai.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Component
public class RandomDataLoader {

    private final VectorStore vectorStore;

    public RandomDataLoader(VectorStore vectorStore){
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadSentenceIntoVectorStore(){
        List<String> sentences = List.of("Apple is known for its innovative consumer electronics and global brand loyalty",
                "Microsoft dominates the software industry with Windows, Azure, and enterprise solutions",
                "Amazon revolutionized e-commerce and continues expanding into cloud computing and AI",
                "Alphabet, Google’s parent company, leads the world in search, ads, and digital services",
                "Nvidia powers the AI revolution with its industry-leading GPUs and chips",
                "Meta Platforms focuses on social media, virtual reality, and digital communication",
                "Tesla is a major player in electric vehicles and clean energy innovation",
                "JPMorgan Chase is one of the largest and most influential financial institutions in the world",
                "Visa operates a global payments network connecting consumers and merchants worldwide",
                "Walmart is the world’s largest retailer with a massive brick-and-mortar and online presence",
                "Mastercard facilitates secure, fast electronic payments across the globe",
                "Johnson & Johnson is a diversified healthcare giant with pharmaceuticals and medical devices",
                "Procter & Gamble produces many of the world’s most trusted household and personal care brands",
                "ExxonMobil is a major energy company involved in oil, gas, and low-carbon technologies",
                "Home Depot is the largest home improvement retailer in the United States",
                "Pfizer develops vaccines and medicines used around the world",
                "Costco is known for its membership-based wholesale retail model",
                "Adobe is a leader in digital creativity and marketing software",
                "Intel designs and manufactures semiconductor chips for computers and data centers",
                "PepsiCo is a global powerhouse in beverages and convenient food products",
                "Canada is known for its stunning natural landscapes and friendly people",
                "Japan blends ancient traditions with cutting-edge technology",
                "France is famous for its art, fashion, and world-class cuisine",
                "India is a vibrant country with rich cultural diversity",
                "Australia offers beautiful beaches, unique wildlife, and vast outback deserts",
                "Italy is celebrated for its history, architecture, and delicious food",
                "Egypt is home to some of the world’s most iconic ancient monuments",
                "Brazil captivates visitors with its lively culture and breathtaking rainforests",
                "Germany is renowned for its engineering, efficiency, and historic cities",
                "Spain is loved for its warm climate, festivals, and Mediterranean lifestyle",
                "Thailand attracts millions with its temples, beaches, and street food",
                "The United States is a vast nation with diverse landscapes and cultures",
                "South Africa offers incredible wildlife and dramatic scenery",
                "Turkey stands at the crossroads of Europe and Asia with deep historical roots",
                "China boasts one of the world’s oldest civilizations and rapid modern growth",
                "New Zealand is famous for its adventure sports and stunning nature",
                "Mexico combines ancient heritage with vibrant modern culture",
                "United Kingdom is known for its history, literature, and iconic landmarks",
                "South Korea leads in pop culture trends and technological innovation",
                "Argentina is celebrated for tango, Patagonia, and exceptional cuisine");
        List<Document> documents = sentences.stream().map(Document::new).collect(Collectors.toList());
        vectorStore.add(documents);
    }
}
