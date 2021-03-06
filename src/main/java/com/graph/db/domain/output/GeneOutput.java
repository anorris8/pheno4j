package com.graph.db.domain.output;

import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.graph.db.domain.input.annotation.TranscriptConsequence;
import com.graph.db.domain.output.annotation.Id;
import com.graph.db.domain.output.annotation.Index;

public class GeneOutput {
	
	@Id(name = "gene_id")
	private final String gene_id;
	@Index
	private final String gene_name;
	private final Integer hgnc_id;
	
	public GeneOutput(Map<String, String> map) {
		this.gene_id = map.get("gene_id");
		this.gene_name = map.get("gene_name");
		this.hgnc_id = null;//TODO
	}

	public GeneOutput(TranscriptConsequence transcriptConsequence) {
		this.gene_id = transcriptConsequence.getGene_id();
		this.gene_name = transcriptConsequence.getGene_symbol();
		this.hgnc_id = transcriptConsequence.getHgnc_id();
	}

	public String getGene_id() {
		return gene_id;
	}

	public String getGene_name() {
		return gene_name;
	}

	public Integer getHgnc_id() {
		return hgnc_id;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.gene_id)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if ((obj instanceof GeneOutput) == false) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		final GeneOutput otherObject = (GeneOutput) obj;
		return new EqualsBuilder()
				.append(this.gene_id, otherObject.gene_id)
				.isEquals();
	}
}
